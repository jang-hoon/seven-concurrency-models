(ns chapter03.day02.reducer)

(println (map (partial * 2) [1 2 3 4]))

(require '[clojure.core.reducers :as r])

(println (r/map (partial * 2) [1 2 3 4]))

(println (reduce conj [] (r/map (partial * 2) [1 2 3 4])))

(println (into [] (r/map (partial * 2) [1 2 3 4])))

(println (into [] (r/map (partial + 1) (r/filter even? [1 2 3 4]))))

