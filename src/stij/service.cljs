(ns stij.service
  (:refer-clojure :exclude [get])
  (:require [stitch-service-client-factories :as factories]))

(defn wrap-service [factory]
  "function to wrap getting a stitch services"
  (fn [name] {:factory factory :name name}))

;;stitch service genorators
(def http    (wrap-service (.-http factories)))
(def aws-S3  (wrap-service (.-awsS3 factories)))
(def aws-SES (wrap-service (.-awsSES factories)))
(def mongo   (wrap-service (.-mongo factories)))
(def twilio  (wrap-service (.-twilio factories)))

;;note according to the stitch typedoc there can be unnamed services
;;but no service currently implements it. this function can handle unnamed
;;services if you hand it {:factory your-unamed-service-factory}
;;see mongodb typedoc on what interfaces a custom service factory
;;service client would have to fulfil
(defn get [client {factory :factory name :name}]
  "gets a clients service"
  (if (some? name)
    (.getServiceClient client factory name)
    (.getServiceClient client factory)))

(defn remote-db [client service-name db-name]
  (-> (get (mongo service-name) client)
      (.db db-name)))

(defn atlas-db [client db-name]
  (remote-db client "mongodb-atlas" db-name))


(defn coll
  ([client service-name db-name coll-name]
   (let [db (remote-db client service-name db-name)]
     (.collection db coll-name)))
  
  ([client db-name coll-name]
   (let [db (atlas-db client db-name)]
     (.collection db coll-name)))
  
  ([db coll-name]
   (.collection db coll-name)))

