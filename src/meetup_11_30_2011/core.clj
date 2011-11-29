;; Nice color themes for projection: Blue Mood, blackOnGray, Dark Blue 2

(ns meetup_11_30_2011.core
  (:use [clojure.repl]))

;; Data / Code

;; Code
(println "Hello World")

;; Data
'(println "Hello World")

;; Data is code, code is data
(eval '(println "Hello World"))

;; Writing a program that writes a program
(eval
 (list* '-> 0 (repeat 5 'inc )))

;; Obligatory unless example

(defn unless [test expr]
  (if (not test) expr))

(defmacro unless [test expr]
  (list 'if (list 'not test) expr))

(defmacro unless [test expr]
  `(if (not ~test) ~expr))

;;;; Debugging macro

(defn ? [val]
  (let [x val]
    (prn val "is" x)
    x))

(defmacro ? [val]
  (list 'let ['x val]
        (list 'prn val "is" 'x)
        'x))

(defmacro ? [val]
  (list 'let ['x val]
        (list 'prn (list 'quote val) "is" 'x)
        'x))

(defmacro ?
  ^{:doc "A useful debugging tool when you can't figure out what's going on: wrap a form with ?, and the form will be printed alongside its result. The result will still be passed along."
    :author "Alan Malloy (@amalloy)"}
  [val]
  `(let [x# ~val]
     (prn '~val '~'is x#)
     x#))