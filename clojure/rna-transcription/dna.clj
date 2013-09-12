(ns dna
  (:require [clojure.string :as string]))

(defn to-rna
  [dna]
  (string/replace dna "T" "U"))
