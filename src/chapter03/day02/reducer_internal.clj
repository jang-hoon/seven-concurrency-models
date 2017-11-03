(ns chapter03.day02.reducer-internal
  (:require
    [clojure.core.protocols :refer [CollReduce coll-reduce]]
  )
)

(defn my-reduce
  ([f coll] (coll-reduce coll f))
  ([f init coll] (coll-reduce coll f init))
)

(println (my-reduce + [1 2 3 4]))
(println (my-reduce + 10 [1 2 3 4]))


(defn make-reducer [reducible transformf]
  (reify
    CollReduce
      (coll-reduce [_ f1] (coll-reduce reducible (transformf f1) (f1)))
      (coll-reduce [_ f1 init] (coll-reduce reducible (transformf f1) init))
  )
)

(defn my-map [mapf reducible]
  (make-reducer reducible (fn [reducef] (fn [acc v] (reducef acc (mapf v)))))
)

(println (into [] (my-map (partial * 2) [1 2 3 4])))
(println (into [] (my-map (partial + 1) [1 2 3 4])))
(println (into [] (my-map (partial * 2) (my-map (partial + 1) [1 2 3 4]))))