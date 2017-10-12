(ns chapter03.day01.parallel (:require [clojure.core.reducers :as r]))

(defn sum [numbers]
  (reduce + numbers)
)

(defn parallel-sum [numbers]
  (r/fold + numbers)
)

(println (parallel-sum [1,2,3,4,5]))

(def numbers (into [] (range 0 10000000)))

(time (sum numbers))
(time (sum numbers))

(time (parallel-sum numbers))
(time (parallel-sum numbers))
