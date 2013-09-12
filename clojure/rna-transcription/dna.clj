(ns dna)

(defn- dna-nucleotide->rna-nucleotide
  [dna]
  (if (= dna \T)
    \U
    dna))

(defn to-rna
  [dna]
  (apply str (map dna-nucleotide->rna-nucleotide dna)))
