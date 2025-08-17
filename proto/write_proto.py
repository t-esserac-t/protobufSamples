from chat_pb2 import Chat
from google.protobuf.json_format import MessageToJson

# Chatメッセージのインスタンスを生成する
msg = Chat(
    sendingPlayerID=101,
    receivingPlayerID=202,
    chatContent="Hello!",
    spoiler=False
)
# シリアライズ
data = msg.SerializeToString()
with open("chat.bin", "wb") as f:
    f.write(data)

print("Wrote chat.bin", len(data), "bytes")
print("As JSON:", MessageToJson(msg))
