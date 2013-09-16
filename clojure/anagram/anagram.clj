(ns anagram
  (:require [clojure.string :as str]))

(defn anagram?
  [word potential-anagram]
  (let [x (frequencies (str/lower-case word))
        potential (frequencies (str/lower-case potential-anagram))
        char-occurances-word (map x (keys potential))]
    (every? identity
            (concat [(= (count word) (count potential-anagram))
                     (not= word potential-anagram)]
                    char-occurances-word
                    (map #(<= %1 %2)
                         (vals potential)
                         char-occurances-word)))))

(defn anagrams-for
  [word potential-anagrams]
  (filter (partial anagram? word) potential-anagrams)
  )
