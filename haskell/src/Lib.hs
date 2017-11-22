module Lib
    ( diamondKata
    ) where

import Data.Char
import Data.List
import System.Environment

spaces :: Int -> String
spaces n = (concat (replicate n [' ']))

charForRow :: Int -> Char
charForRow row = (chr (row + 64))

getRow :: Int -> Int -> String
getRow order row =
    (spaces (order - row)) ++
    [charForRow row] ++
    (spaces (((row-1)*2)-1)) ++
    [if row == 1 then ' ' else charForRow row]

prependTo a b = b : a

myReverse(someList) = (foldl prependTo [] someList)

getOrder :: IO Int
getOrder = do
    args <- getArgs
    return (read (head args))

diamondKata :: IO ()
diamondKata = do
    order <- getOrder
    (putStrLn
        (concat
            (intersperse "\n"
                (map (getRow order)
                    ([1..order] ++ (myReverse [1..(order-1)]))))))
