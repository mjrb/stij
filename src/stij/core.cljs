(ns stij.core
  (:require [stitch :as stitch]
            [stij.login :as login]))

(enable-console-print!)

(defn default-client! [api-key] (.initializeDefaultAppClient stitch api-key))
(defn client [api-key] (.initializeAppClient stitch api-key))
(defn mongodb [client db-name] "not implemented yet")
(def test-client (client "testreact-xyknf"))
(-> (login/anonymous test-client)
    (.then js/console.log)
    (.catch js/alert))

(defn on-js-reload [] "")

