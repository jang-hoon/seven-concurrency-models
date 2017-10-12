(ns chapter03.day01.fundamental)

(println (max 3 5))

(println (+ 1 (* 2 3)))

(def meaning-of-life 42)
(println meaning-of-life)

(println (if (< meaning-of-life 0) "negative" "non-negative"))

(def droids ["Huey" "Dewey" "Louie"])
(println (count droids))
(println (droids 0))
(println (droids 2))

(def me {:name "Paul" :age 45 :sex :male})
(println (:age me))

(defn percentage [x p] (* x (/ p 100.0)))
(println (percentage 200 10))
