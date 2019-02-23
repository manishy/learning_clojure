; factorial -----------------------

(defn factorial [x]
  (if (> 1 x) 1
      (* x (factorial (dec x)))))

(factorial 4)

; my-drop -------------------------
(defn my-drop [till coll]
  (loop [count till c coll]
    (if (or (empty? c) (= count 0))
      c
      (recur (- count 1) (rest c)))))

(my-drop 2 [1 2 3 4 5])
(drop 2 [])

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
    (if (empty? c)
      final
      (if (f (first c))
        (recur (rest c) (conj final (first c)))
        (recur (rest c) final)))))

(my-filter even? '(1 2 3 4 5))

; my-reduce   ------------------------
(defn my-reduce [f coll]
  (loop [c coll final 0]
    (
     if (empty? c) final (recur (rest c) (f final (first c)))
     )
    )
  )



(my-reduce - '(1 2 3 4))






; (def foo (comp (partial take-while not-nil?) (partial iterate remove-first-and-last)))
; (foo "albla")


; is-prime?  ----------------------------------------------
; find factors of given number

; (def is-prime? ())

; (rem 3 2)
; comp , partial , apply ,repeat,  

