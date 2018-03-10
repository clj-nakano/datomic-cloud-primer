---

# Datomic Cloud Primer

- clj-nakano #5 2018/3/14
- 株式会社シグニファイア代表 中村研二 (github: k2n, twitter: @k2nakamura)

---

## Datomic Cloudを起動する

---

## Datomic Cloudに開発環境から接続する

---

## Music Brainzサンプルデータをアップロード

- [mbrainz-sample](https://github.com/Datomic/mbrainz-sample)はDatomic On-prem向けのサンプルデータ
  - 手順はDatomic Cloudに適用できない
  - 今のところ、Datomic Cloud向けimporter/exporterはバンドルされていない
-  [mbrainz-importer](https://github.com/Datomic/mbrainz-importer)

```
[kenji@k2n-mbp13: ] clojure -m datomic.mbrainz.importer config/manifest.edn
Loading batch file for  :schema
Batches already completed:  0
.{:process {:forms 1}, :result {:txes 1, :datoms 304}}
"Elapsed time: 370.702508 msecs"
Loading batch file for  :enums
Batches already completed:  1
.{:process {:forms 1}, :result {:txes 1, :datoms 61}}
"Elapsed time: 271.003751 msecs"
Loading batch file for  :super-enums
Batches already completed:  2
.{:process {:forms 1}, :result {:txes 1, :datoms 16388}}
"Elapsed time: 3297.400394 msecs"
Loading batch file for  :artists
Batches already completed:  3
.{:process {:forms 1}, :result {:txes 1, :datoms 28647}}
"Elapsed time: 2553.08423 msecs"
Loading batch file for  :areleases
Batches already completed:  4
..{:process {:forms 2}, :result {:txes 2, :datoms 40568}}
"Elapsed time: 3044.449518 msecs"
Loading batch file for  :areleases-artists
Batches already completed:  6
..{:process {:forms 2}, :result {:txes 2, :datoms 10560}}
"Elapsed time: 3605.920163 msecs"
Loading batch file for  :labels
Batches already completed:  8
.{:process {:forms 1}, :result {:txes 1, :datoms 6157}}
"Elapsed time: 736.040537 msecs"
Loading batch file for  :releases
Batches already completed:  9
..{:process {:forms 2}, :result {:txes 2, :datoms 103856}}
"Elapsed time: 5708.891189 msecs"
Loading batch file for  :releases-artists
Batches already completed:  11
..{:process {:forms 2}, :result {:txes 2, :datoms 11810}}
"Elapsed time: 2640.703704 msecs"
Loading batch file for  :media
Batches already completed:  13
...........{:process {:forms 11}, :result {:txes 11, :datoms 874556}}
"Elapsed time: 46358.909202 msecs"
"Elapsed time: 68590.385983 msecs"
```
