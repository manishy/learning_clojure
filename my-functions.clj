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


; is-prime?   ---------------------------------------

(def is-equal-to-two? (partial = 2))

(def possible-factors (comp rest (partial range) inc))

(def is-divisible(comp zero? (partial apply rem)))

(def repeat-last (comp (partial apply repeat) (juxt last last)))

(def make-pair (partial apply map list)) 

(def pair-of-divisor-and-dividend (comp make-pair (juxt repeat-last identity)))

(def filter-actual-factors (comp (partial map second) (partial filter is-divisible) pair-of-divisor-and-dividend))

(def is-prime? (comp 
                is-equal-to-two?
                count
                filter-actual-factors
                possible-factors))             ; Have to handle is-prime? for Zero 

(is-prime? 2)
(is-prime? 2)
(is-prime? 4)
(is-prime? 5)
(is-prime? 7)
(is-prime? 11)
(is-prime? 13)
(is-prime? 17)
(is-prime? 19)
(is-prime? 1)
; (is-prime? 0)          ; have to handle this case
; (is-prime? -1)



; nth-prime  ------------------------------

(def infinite-prime-series ( partial filter is-prime? (rest (range))))

(def n-prime-series #(take %1 (infinite-prime-series)))

(def nth-prime (comp last n-prime-series))

(nth-prime 100)
(nth-prime 1)
(nth-prime 2)
(nth-prime 5)
(nth-prime 6)



; sub-set of  -------------------------------

