(ns diamond.core
  (:gen-class))

(def asci-a (-> \a int dec))

(defn line-char [line-num levels]
  (-> (if (< line-num levels)
          (+ asci-a line-num)
          (- (+ asci-a levels) (- line-num levels)))
      char str) )

(defn line-string-inner [outer-spaces internal-spaces this-char]
  (let [double-internal-spaces (apply str (repeat (- (* 2 internal-spaces) 1) " "))]
    (str outer-spaces this-char double-internal-spaces this-char)))

(defn get-line-string [outer-spaces internal-spaces this-char]
  (if (= this-char "a")
    (str outer-spaces this-char)
    (line-string-inner outer-spaces internal-spaces this-char)) )

(defn get-outer-spaces [levels internal-spaces]
  (apply str (-> levels (- internal-spaces) (repeat " "))))

(defn line-string [line-num levels]
  (let [this-char (line-char line-num levels)
        internal-spaces (-> (.charAt this-char 0) int (- (inc asci-a)))
        outer-spaces (get-outer-spaces levels internal-spaces)]
    (get-line-string outer-spaces internal-spaces this-char)
    ))

(defn get-diamond [levels lines]
  (loop [line 1 diamond []]
      (if (<= line lines)
        (recur (inc line) (conj diamond (line-string line levels)))
        diamond))
  )

(defn -main
  "Diamond Kata by Prodge"
  [arg]
  (let [levels (- (int (.charAt arg 0)) asci-a)
        lines (- (* 2 levels) 1)]
      (doall (map println (get-diamond levels lines)))
    ))


