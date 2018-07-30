(ns stij.core
  (:require [stitch :as stitch]
            [stij.login :as login]
            [stij.service :as service]))

(enable-console-print!)

(defn set-default-client! [api-key]
  (.initializeDefaultAppClient stitch api-key))

(defn client! [api-key]
  (str "this is stateful :( and saves the client internaly"
       "so you don't have to keep making sure the client is logged in")
  (.initializeAppClient stitch api-key))

(defn has-client? [app-id]
  (.hasAppClient stitch app-id))

(defn get-default-client []
  (.defaultAppClient stitch))

(defn get-client [app-id]
  (.getAppClient stitch app-id))



(def test-client (if (has-client? api-key)
                   (get-client api-key)
                   (let [temp-client (client! api-key)]
                     (-> temp-client
                         (login/anonymous)
                         ;;(.then js/console.log))))
                         (.then (fn [whatever] temp-client))))))
  
(-> test-client
    (.then js/console.log)
    (.catch js/alert))
    ;; (.then (fn [whatever]
    ;;          (service/get client service/http)))
;;             )

(defn on-js-reload [] "")

