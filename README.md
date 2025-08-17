# protobufSamples

このリポジトリは、Protocol Buffers (protobuf) を Python と Java で試すためのサンプルです。公式ドキュメントや調査メモを基に、シリアライズとデシリアライズの手順を簡単にまとめています。

## プロジェクト概要
- `proto/chat.proto` … チャットメッセージのスキーマ定義
- `proto/write_proto.py` … Python でチャットメッセージをバイナリ化するスクリプト
- `proto/java/src/Main.java` … Java で `chat.bin` を読み込むサンプル

## 準備
1. [protoc](https://protobuf.dev/installation/) をインストールし、`protoc --version` が実行できるように PATH を通す。
2. このリポジトリを取得し、ルートディレクトリで作業する。

## Python での利用
1. protobuf ランタイムをインストールする。
   ```sh
   python -m pip install protobuf
   ```
2. `proto` ディレクトリに移動し、`.proto` から Python コードを生成する。
   ```sh
   protoc --python_out=. chat.proto
   ```
3. シリアライズを実行する。
   ```sh
   python write_proto.py
   ```
   `chat.bin` と JSON 形式での出力が確認できれば成功。

## Java での利用
1. `proto` ディレクトリで Java コードを生成する。
   ```sh
   protoc --java_out=./java/src chat.proto
   ```
2. 必要な JAR (`protobuf-java-x.y.z.jar`) を `proto/java/lib` に配置する。
3. Java ソースをコンパイルする。
   ```sh
   cd proto/java
   mkdir -p out
   javac -cp "lib/protobuf-java-4.32.0.jar" -d out src/ChatOuterClass.java src/Main.java
   ```
4. デシリアライズを実行する。
   ```sh
   java -cp out:lib/protobuf-java-4.32.0.jar Main
   ```
   Python で生成した `chat.bin` の内容が表示されれば成功。

## 参考資料
- [Protocol Buffers 公式サイト](https://protobuf.dev/)
- [Language Guide (Proto3)](https://protobuf.dev/programming-guides/proto3/)
- https://stackoverflow.com/questions/64048132/proto-path-passed-empty-directory-name
- https://wa3.i-3-i.info/word15008.html
- https://apidog.com/jp/blog/protobuf-grpc-basis/
- https://central.sonatype.com/artifact/com.google.protobuf/protobuf-java/4.32.0
- https://abi-laboratory.pro/?l=protobuf&v=3.5.1&view=changelog
- https://zenn.dev/ken7253/articles/vscode-with-hexeditor
- https://developer.medley.jp/entry/2020/08/21/190934/

