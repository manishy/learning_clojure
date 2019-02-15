; factorial -----------------------

(defn factorial [x]
  (if (> 1 x) 1
      (* x (factorial (dec x)))))

(factorial 4)

; my-map  -------------------------

; (defn my-map [f coll]
;   (loop [f c coll final []]
;     (if (empty? c) final
;         (recur (f (rest c) )) (conj final (f (first c))) ))
;   )

(defn my-map [f coll]
  (if (empty? coll)))


(my-map f [2 3 4])