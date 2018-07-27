(ns stij.login
  (:require [stitch-credentials :as credentials]))

(defn login [client credential]
  "logs in a client with given credential"
  (.loginWithCredential client.auth credential))

(defn anonymous [client]
  (login client (new (.-anonymous credentials))))

;;todo test
(defn user-password
  ([client username password]
   (login client (new (.-userPassword credentials) username password)))
  ([client username password provider-name]
   (login client (new (.-userPassword credentials) username password provider-name))))

;;todo test
(defn custom
  ([client token]
   (login client (new (.-custom credentials) token)))
  ([client token provider-name]
   (login client (new (.-custom credentials) token provider-name))))

;;todo test
(defn facebook 
  ([client token]
   (login client (new (.-facebook credentials) token)))
  ([client token provider-name]
   (login client (new (.-facebook credentials) token provider-name))))
;;todo implement all methods
