(ns clojush.examples.kata.stats-bowling
  (:use [clojush.pushgp.pushgp]
        [clojush.examples.kata.bowling-helper]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;Enumerate test cases based on strike, spare, both, and none
(defn test-cases-type
  [tcs]
  (map-indexed #(vector %1 %2 (if (some #{\X} (first %2))
                                (if (some #{\/} (first %2))
                                  :both
                                  :strike)
                                (if (some #{\/} (first %2))
                                  :spare
                                  :none)))
               tcs))

(defn get-test-cases-type
  [type tcs]
  (filter #(= (nth % 2) type) (test-cases-type tcs)))

(defn get-test-cases-type-numbers
  [type tcs]
  (map first (get-test-cases-type type tcs)))


(count (get-test-cases-type-numbers :strike test-cases))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn Rify-column-names
  [type]
  (println (str "(TC"
                (apply str (interpose ", TC" (get-test-cases-type-numbers type)))
                ")")))

;(Rify-column-names :spare)


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Number of characters used total in test cases

(def bowling-chars
  "-123456789/X")

(defn char-counter
  [test-cases]
  (let [char-string (reduce str (map first test-cases))]
    (for [c bowling-chars]
      (vector c (count (filter #(= % c) char-string))))))

;(char-counter test-cases)