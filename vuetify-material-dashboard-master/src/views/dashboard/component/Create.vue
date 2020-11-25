<template>
  <v-container id="alerts" fluid tag="section">
    <base-v-component heading="" link="components/alerts" />

    <div>
      <v-row>
        <v-col cols="12">
          <v-card>
            <v-card-text>
              <base-subheading subheading="자유 게시판" />
              <div>
                <label for="writer">작성자</label>

                <v-text-field
                  type="text"
                  id="writer"
                  ref="writer"
                  placeholder="작성자를 입력하세요"
                  v-model="writer"
                  class="purple-input"
                />
              </div>
              <div>
                <label for="title">제목</label>
                <v-text-field
                  id="title"
                  ref="title"
                  placeholder="제목을 입력하세요"
                  v-model="title"
                  class="purple-input"
                />
              </div>
              <div>
                <label for="content">내용</label>
                <v-text-field
                  id="content"
                  ref="content"
                  placeholder="내용을 입력하세요"
                  v-model="content"
                  class="purple-input"
                />
              </div>
              <div>
                <v-btn
                  color="success"
                  class="mr-0"
                  type="create"
                  @click="checkHandler"
                >
                  등록
                </v-btn>
                <v-btn color="success" class="mr-0" @click="moveList">
                  목록
                </v-btn>
              </div>
            </v-card-text>
          </v-card>
        </v-col>
      </v-row>
    </div>
  </v-container>
</template>

<script>
import Vue from "vue";
import VueRouter from "vue-router";
import axios from "axios";
import moment from "moment";

export default {
  name: "DashboardNotifications",
  props: {
    type: { type: String }
  },
  data: function() {
    return {
      no: "",
      regtime: "",
      writer: "",
      title: "",
      content: ""
    };
  },
  computed: {
    //parsedDirection () {
    //  return this.direction.split(' ')
    //},
  },
  created() {
    axios
      .get("http://localhost:8080/VueApi/api/board")
      .then(({ data }) => {
        this.items = data;
      })
      .catch(() => {
        alert("에러가 발생했습니다.");
      });
  },
  methods: {
    //randomColor () {
    //  this.color = this.colors[Math.floor(Math.random() * this.colors.length)]
    //},
    movePage() {
      this.$router.push("/create");
    },
    getFormatDate(regtime) {
      return moment(new Date(regtime)).format("YYYY.MM.DD");
    },
    checkHandler() {
      let err = true;
      let msg = "";
      !this.writer &&
        ((msg = "작성자를 입력해주세요"),
        (err = false),
        this.$refs.writer.focus());
      err &&
        !this.title &&
        ((msg = "제목 입력해주세요"), (err = false), this.$refs.title.focus());
      err &&
        !this.content &&
        ((msg = "내용 입력해주세요"),
        (err = false),
        this.$refs.content.focus());

      if (!err) alert(msg);
      else this.createHandler();
    },
    createHandler() {
      axios
        .post("http://localhost:8080/VueApi/api/board/", {
          writer: this.writer,
          title: this.title,
          content: this.content
        })
        .then(({ data }) => {
          let msg = "등록 처리시 문제가 발생했습니다.";
          if (data === "success") {
            msg = "등록이 완료되었습니다.";
          }
          alert(msg);
          this.moveList();
        })
        .catch(() => {
          alert("등록 처리시 에러가 발생했습니다.");
        });
    },
    moveList() {
      this.$router.push("components/notifications");
    }
  }
};
</script>
