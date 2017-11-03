(ns chapter03.day02.fold-frequencies
  (:require [clojure.core.reducers :as r])
)


(defn parallel-frequencies [coll]
  (r/fold
    (partial merge-with +)
    (fn [counts x] (assoc counts x (inc (get counts x 0))))
    coll
  )
)

(defn parallel-frequencies [coll]
  (r/fold
    (partial merge-with +)
    (fn [counts x] (assoc counts x (inc (get counts x 0))))
    coll
  )
)

(println (take 10 (repeatedly #(rand-int 10))))

(def numbers (into [] (take 10000000 (repeatedly #(rand-int 10)))))
(println (time (frequencies numbers)))
(println (time (parallel-frequencies numbers)))
