(ns chapter03.day01.wordcount)

(def counts {"apple" 2 "orange" 1})

(println (get counts "apple" 0))
(println (get counts "banana" 0))
(println (assoc counts "banana" 1))
(println (assoc counts "apple" 3))


(defn word-frequencies [words]
  (reduce
    (fn [counts word] (assoc counts word (inc (get counts word 0))))
    {}
    words
  )
)

(println (word-frequencies ["one" "potato" "two" "potato" "three" "potato" "four"]))
(println (frequencies ["one" "potato" "two" "potato" "three" "potato" "four"]))


(println (map inc [0 1 2 3 4 5]))
(println (map (fn [x] (* 2 x)) [0 1 2 3 4 5]))


(def multiply-by-2 (partial * 2))

(println (multiply-by-2 3))
(println (map (partial * 2) [0 1 2 3 4 5]))
(println (map multiply-by-2 [0 1 2 3 4 5]))


(println ((partial + 2) 1))
(println ((partial (fn [x y z] (+ x (+ y z))) 2 3) 1))



(defn get-words [text] (re-seq #"\w+" text))

(println (get-words "one two three four"))
(println (map get-words ["one two three" "four five six" "seven eight nine"]))
(println (mapcat get-words ["one two three" "four five six" "seven eight nine"]))


(defn count-words-sequential [pages]
  (frequencies (mapcat get-words pages))
)

(println (count-words-sequential ["one two three" "four five six" "seven eight nine" "one two three four"]))
