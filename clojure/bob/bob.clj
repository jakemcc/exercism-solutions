(ns bob)

(defn- silence? [phrase]
  (empty? (.trim phrase)))

(defn- shouting? [phrase]
  (and (not (silence? phrase))
       (= (.toUpperCase phrase) phrase)))

(defn- question? [phrase]
  (.endsWith phrase "?"))

(defn response-for [phrase]
  (cond
   (silence? phrase)  "Fine. Be that way!"
   (shouting? phrase) "Woah, chill out!"
   (question? phrase) "Sure."
   :else              "Whatever."))
