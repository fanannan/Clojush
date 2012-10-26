(ns clojush.examples.kata.bowling-lexicase-gsxover
  (:use [clojush.pushgp.pushgp]
        [clojush.examples.kata.bowling-helper]))

;;;;;;;;;;
;; Run PushGP on KataBowling

(pushgp
  :error-function kata-bowling-error-function
  :atom-generators kata-bowling-atom-generators
  :max-points 2500
  :max-points-in-initial-program 250
  :evalpush-limit 3000
  :population-size 5000
  :max-generations 400
  :mutation-probability 0.1
  :mutation-max-points 10
  :crossover-probability 0.2
  :simplification-probability 0.3
  :boolean-gsxover-probability 0.4
  :boolean-gsxover-new-code-max-points 10
  :node-selection-method :size-tournament
  :node-selection-tournament-size 2
  :report-simplifications 0
  :final-report-simplifications 1000
  :use-lexicase-selection true
  )