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
  (string/split phrase #" "))

(defn word-count [phrase]
  (-> phrase
      string/lower-case
      remove-special-characters
      words
      remove-blank
      frequencies))
