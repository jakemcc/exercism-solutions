(ns anagram
  (:require [clojure.string :as str]))

(defn same-letters? [word other-word]
  (= (sort (str/lower-case word))
     (sort (str/lower-case other-word))))

(defn anagram?
  [word potential-anagram]
  (and (not= word potential-anagram)
       (same-letters? word potential-anagram)))

(defn anagrams-for
  [word potential-anagrams]
  (filter (partial anagram? word) potential-anagrams))
