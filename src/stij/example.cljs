(ns stij.example
  (:require [stij.login :as login]
            [stij.core :as stij]
            [stij.service :as service]))
(def api-key "<test stij app key>")
;;in the stitch console you must enable anonymous auth
;;and add a atlas policy to the namespace test.testObjects
;;for owners to read their own documents

(enable-console-print!)

(stij/set-default-client! api-key)
(def testclient (stij/get-default-client))

(-> (login/anonymous testclient)
    (.then
     (fn [user]
       (print "logged in")
       (js/console.log user)
         (let [objs (service/coll testclient "test" "testObjects")]
           (-> (.find objs)
               (.asArray)))))
    (.catch js/alert)
    (.then (fn [coll]
             (js/console.log coll "here")))
    (.catch js/console.log))

(defn on-js-reload [] (.reload js/window.location true))
