(ns chapter03.day02.each)

(defn get-words [text] (re-seq #"\w+" text))

(def pages ["one potato two potato three potato four" "five potato six potato seven potato more"])

(println (pmap #(frequencies (get-words %)) pages))


(def merge-counts (partial merge-with +))

(println (merge-counts {:x 1 :y 2} {:y 1 :z 1}))


(defn count-words-parallel [pages]
  (reduce
    (partial merge-with +)
    (pmap #(frequencies (get-words %)) pages)
  )
)

(println (count-words-parallel pages))
