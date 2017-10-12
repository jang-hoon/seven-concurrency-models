(ns chapter03.day01.firstapp)

(defn recursive-sum [numbers]
  (if (empty? numbers)
    0
    (+ (first numbers) (recursive-sum (rest numbers)))
  )
)

(println (recursive-sum [1, 2, 3, 4, 5]))

(defn reduce-sum [numbers]
  (reduce (fn [acc x] (+ acc x)) 0 numbers)
)

(println (reduce-sum [1, 2, 3, 4 ,5]))

(defn sum [numbers]
  (reduce + numbers)
)

(println (sum [1, 2, 3, 4, 5]))


(defn printArray [numbers]
  (reduce
    (fn [acc x]
      (do
        (println (str "acc : " acc ", x : " x))
        (+ acc x)
      )
    )
    0
    numbers
  )
)

(printArray [1, 2, 3, 4, 5])
