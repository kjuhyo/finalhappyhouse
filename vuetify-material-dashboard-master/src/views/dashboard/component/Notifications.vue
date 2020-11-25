<template>
  <v-container id="alerts" fluid tag="section">
    <base-v-component heading="" link="components/alerts" />

    <div>
      <v-row>
        <v-col cols="12">
          <v-card>
            <v-card-text>
              <base-subheading subheading="자유 게시판" />

              <!--<base-material-alert
              v-for="color in colors"
              :key="color"
              :color="color"
              dark
              dismissible
            >
              <span
                class="text-uppercase"
              /> 
            </base-material-alert>-->
              <table>
                <colgroup>
                  <col :style="{ width: '5%' }" />
                  <col :style="{ width: '50%' }" />
                  <col :style="{ width: '10%' }" />
                  <col :style="{ width: '25%' }" />
                </colgroup>
                <tr>
                  <th>No</th>
                  <th>제목</th>
                  <th>작성자</th>
                  <th>날짜</th>
                </tr>
                <tr v-for="(item, index) in items" :key="`${index}_items`">
                  <td>{{ item.no }}</td>
                  <td>
                    <router-link :to="`/read?no=${item.no}`">{{
                      item.title
                    }}</router-link>
                  </td>
                  <td>{{ item.writer }}</td>
                  <td>{{ getFormatDate(item.regtime) }}</td>
                </tr>
              </table>
            </v-card-text>
            <v-btn color="success" class="mr-0" @click="movePage"> 등록</v-btn>
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
    no: { type: Number },
    writer: { type: String },
    title: { type: String },
    regtime: { type: String }
  },
  data: function() {
    return {
      items: []
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
    }
  }
};
</script>
