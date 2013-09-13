(ns phrase
  (:refer-clojure :exclude [empty?])
  (:require [clojure.string :as string]))

(defn- empty? [s]
  (clojure.core/empty? (string/trim s)))

(defn- remove-blank [words]
  (remove empty? words))

(defn- remove-special-characters [s]
  (string/replace s #"[^a-z0-9 ]" ""))

(defn- words [phrase]
  (-> phrase
      string/lower-case
      remove-special-characters
      (string/split #" ")
      remove-blank))

(defn word-count [phrase]
  (frequencies (words phrase)))
