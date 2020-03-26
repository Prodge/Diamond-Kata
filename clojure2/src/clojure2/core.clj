(ns clojure2.core
  (:gen-class))

(def asci-a (int \a))

(defn spaces [n]
  (apply str (repeat n " ")))

(defn start-spaces [line order]
  (spaces (- order line)))

(defn middle-spaces [line]
  (-> line (* 2) dec spaces))

(defn row-letter [row]
  (-> asci-a (+ row) char str))

(defn line-string [line order]
  (apply str
    (if (zero? line)
      [(spaces order) "a"]
      [(start-spaces line order) (row-letter line) (middle-spaces line) (row-letter line)])))

(defn get-diamond-top [order]
  (loop [line 0 diamond []]
    (if (<= line order)
      (recur (inc line) (conj diamond (line-string line order)))
      diamond)))

(defn get-diamond [order]
  (let [top (get-diamond-top order)]
    (into top (reverse (butlast top)))))

(defn -main
  "Diamond Kata by Prodge"
  [arg]
  (let [order (-> arg first int (- asci-a))]
    (doall (map println (get-diamond order)))))

