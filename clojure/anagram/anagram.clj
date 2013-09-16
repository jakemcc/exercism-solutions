(ns anagram
  (:require [clojure.string :as str]))

(defn same-letters? [word other-word]
    (let [x (frequencies (str/lower-case word))
        potential (frequencies (str/lower-case other-word))
        char-occurances-word (map x (keys potential))]
    (every? identity
            (concat char-occurances-word
                    (map #(<= %1 %2)
                         (vals potential)
                         char-occurances-word)))))

(defn anagram?
  [word potential-anagram]
  (and (not= word potential-anagram)
       (= (count word) (count potential-anagram))
       (same-letters? word potential-anagram)))

(defn anagrams-for
  [word potential-anagrams]
  (filter (partial anagram? word) potential-anagrams))
