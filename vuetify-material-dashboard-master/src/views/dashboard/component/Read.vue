<template>
  <v-container id="alerts" fluid tag="section">
    <base-v-component heading="" link="" />

    <div>
      <v-row>
        <v-col cols="12">
          <v-card>
            <v-card-text>
              <base-subheading subheading="자유 게시판" />
              <!-- <div>
                <detail
                  :content="item.content"
                  :title="item.title"
                  :writer="item.writer"
                  :regtime="item.regtime"
                  :no="item.no"
                />
              </div>-->
              <table>
                <tr>
                  <th>번호</th>
                  <td>{{ item.no }}</td>
                </tr>
                <tr>
                  <th>글쓴이</th>
                  <td>{{ item.writer }}</td>
                </tr>
                <tr>
                  <th>제목</th>
                  <td>{{ item.title }}</td>
                </tr>
                <tr>
                  <th>날짜</th>
                  <td>{{ getFormatDate(item.regtime) }}</td>
                </tr>
                <tr>
                  <td colspan="2">
                    {{ item.content }}
                  </td>
                </tr>
              </table>
            </v-card-text>
            <v-btn color="success" class="mr-0" @click="moveList"> 목록</v-btn>
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

  data: function() {
    return {
      item: []
    };
  },
  computed: {
    //parsedDirection () {
    //  return this.direction.split(' ')
    //},
  },

  created() {
    axios
      .get(`http://localhost:8080/VueApi/api/board/${this.$route.query.no}`)
      .then(({ data }) => {
        this.item = data;
        console.log(this.item);
      })
      .catch(() => {
        alert("에러가 발생했습니다.");
      });
  },
  methods: {
    getFormatDate(regtime) {
      return moment(new Date(regtime)).format("YYYY.MM.DD HH:mm:ss");
    },
    moveList() {
      this.$router.push("components/notifications");
    }
  }
};
</script>
