(ns stij.core
  (:require [stitch :as stitch]))

(defn set-default-client! [api-key]
  (.initializeDefaultAppClient stitch api-key))

(defn client! [api-key]
  (str "this is stateful :( and saves the client internaly"
       "so you don't have to keep making sure the client is logged in")
  (.initializeAppClient stitch api-key))

(defn has-client? [app-id]
  (.hasAppClient stitch app-id))

(defn get-default-client []
  (.-defaultAppClient stitch))

(defn get-client [app-id]
  (.getAppClient stitch app-id))
