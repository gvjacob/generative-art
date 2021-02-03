(ns generativeart.core
  (:require [quil.core :as q]
            [quil.middleware :as m]
            [generativeart.dynamic :as dynamic]))

(q/defsketch generativeart
  :title "You spin my circle right round"
  :size [900 900]
  ; setup function called only once, during sketch initialization.
  :setup dynamic/setup
  ; update-state is called on each iteration before draw-state.
  :update dynamic/update-state
  :draw dynamic/draw-state
  ; This sketch uses functional-mode middleware.
  ; Check quil wiki for more info about middlewares and particularly
  ; fun-mode.
  :middleware [m/fun-mode])

(defn refresh []
  (use :reload 'generativeart.dynamic)
  (.loop generativeart))
