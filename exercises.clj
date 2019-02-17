; factorial -----------------------

(defn factorial [x]
  (if (> 1 x) 1
      (* x (factorial (dec x)))))

(factorial 4)

; my-map  -------------------------

(defn my-map [f coll]
  (loop [c coll final []]
    (if (empty? c) final
        (recur (rest c) (conj final (f (first c)))
               )
        )
    )
)

(my-map #(* % 2) '(1 2 3 4))
(my-map even? [1 2 3 4])


; my-filter  -----------------------

(defn my-filter [f coll]
  (loop [c coll final []]
    (if (empty? c) final
        (
         if (f (first c)) (recur (rest c) (conj final (first c))) (recur (rest c) final)
          )
        )
    )
  )

(my-filter even? '(1 2 3 4 5))
