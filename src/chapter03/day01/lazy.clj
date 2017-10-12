(ns chapter03.day01.lazy)

(println (range 0 10))
;(println (range 0 100000000))

(println (take 10 (range 0 100000000)))
(println (take 10 (map (partial * 2) (range 0 100000000))))

(println (take 10 (iterate inc 0)))
(println (take 10 (iterate (partial + 2) 0)))

(println (take-last 5 (range 0 100000000)))