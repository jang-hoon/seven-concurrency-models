(ns chapter03.day02.fold
  (:require
    [clojure.core.protocols :refer [CollReduce coll-reduce]]
    [clojure.core.reducers :refer [CollFold coll-fold]]
  )
)

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

(defn my-fold
  ([reducef coll] (my-fold reducef reducef coll))
  ([combinef reducef coll] (my-fold 512 combinef reducef coll))
  ([n combinef reducef coll] (coll-fold coll n combinef reducef))
)

(defn make-reducer [reducible transformf]
  (reify
    CollFold
    (coll-fold [_ n combinef reducef] (coll-fold reducible n combinef (transformf reducef)))

    CollReduce
    (coll-reduce [_ f1] (coll-reduce reducible (transformf f1) (f1)))
    (coll-reduce [_ f1 init] (coll-reduce reducible (transformf f1) init))
  )
)

(def v (into [] (range 10000)))

(println (my-fold + v))
(println (my-fold + (my-map (partial * 2) v)))