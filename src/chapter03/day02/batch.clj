(ns chapter03.day02.batch)

(defn get-words [text] (re-seq #"\w+" text))

(def pages ["one potato two potato three potato four" "five potato six potato seven potato more"])

(defn count-words-sequential [pages]
  (frequencies (mapcat get-words pages))
)

(defn count-words [pages]
  (reduce
    (partial merge-with +)
    (pmap count-words-sequential (partition-all 100 pages))
  )
)

(println (partition-all 4 [1 2 3 4 5 6 7 8 9 10]))

(println (count-words pages))

