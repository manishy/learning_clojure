; my-square         -------------------------------------

(def product-of (partial apply *))

(def numbers (partial repeat 2))

(def my-square (comp product-of numbers))

(my-square 6)




; is-palindrome?   ---------------------------------------

(def remove-first-and-last (comp butlast rest))

(def first-and-last (juxt first last))

(def first-and-last-are-equal? (comp (partial apply =) first-and-last))

(def not-nil? (comp not nil?))

(def are-every-pairs-equal? (partial every? first-and-last-are-equal?))

(def set-of-pair-of-firsts-and-lasts ( comp (partial take-while not-nil?) (partial iterate remove-first-and-last)))

(def is-palindrome?
  (comp
   are-every-pairs-equal?
   set-of-pair-of-firsts-and-lasts
   ))

(is-palindrome? "")
(is-palindrome? "a")
(is-palindrome? "ab")
(is-palindrome? "aba")
(is-palindrome? "1")
(is-palindrome? [1 2 3 2 1])

