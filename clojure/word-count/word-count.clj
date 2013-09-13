(ns phrase
  (:require [clojure.string :as string]))

(defn- words [phrase]
  (-> phrase
      string/lower-case
      (string/split #"\W+")))

(defn word-count [phrase]
  (frequencies (words phrase)))
