(ns phrase
  (:require [clojure.string :as string]))

(defn- words [phrase]
  (->> phrase
      string/lower-case
      (re-seq #"\w+")))

(defn word-count [phrase]
  (frequencies (words phrase)))
