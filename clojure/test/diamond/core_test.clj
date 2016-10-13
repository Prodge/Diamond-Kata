(ns diamond.core-test
  (:require [clojure.test :refer :all]
            [diamond.core :refer :all]))

(deftest line-char-test
  (testing "Getting a character at a given line"
    (is (= (line-char 1 3) "a"))
    (is (= (line-char 3 3) "c"))
    (is (= (line-char 5 3) "a"))
    ))

(deftest line-string-test
  (testing "Generating the string to be printed on the given line"
    (is (= (line-string 1 3) "   a"))
    (is (= (line-string 3 3) " c   c"))
    (is (= (line-string 4 3) "  b b"))
    ))

(deftest get-diamond-test
  (testing "The collection for the final structure is valid"
    (is (= (get-diamond 3 5)
           ["   a"
			"  b b"
			" c   c"
			"  b b"
			"   a"]))))
