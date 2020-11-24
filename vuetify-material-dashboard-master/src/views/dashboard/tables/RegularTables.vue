<template>
  <v-container id="regular-tables" fluid tag="section">
    <base-v-component heading="Simple Tables" link="components/simple-tables" />
    <v-container>
      <v-row>
        <v-col cols="7"></v-col>
        <v-col
          ><v-select v-model="sisel" :items="sido" label="시도"></v-select
        ></v-col>
        <v-col
          ><v-select v-model="gugunsel" :items="gugun" label="구군"></v-select
        ></v-col>
        <v-col
          ><v-select v-model="dongsel" :items="dong" label="동"></v-select
        ></v-col>
        <v-col>
          <v-text-field
            :label="$t('search')"
            color="secondary"
            hide-details
            style="max-width: 165px"
          >
            <template v-if="$vuetify.breakpoint.mdAndUp" v-slot:append-outer>
              <v-btn class="mt-n2" elevation="1" fab small>
                <v-icon>mdi-magnify</v-icon>
              </v-btn>
            </template>
          </v-text-field>
        </v-col>
      </v-row>
    </v-container>

    <base-material-card
      icon="mdi-clipboard-text"
      title="아파트 거래정보"
      class="px-5 py-3"
    >
      <v-simple-table>
        <thead>
          <tr>
            <th class="primary--text">동</th>
            <th class="primary--text">이름</th>
            <th class="primary--text">가격</th>
            <th class="primary--text">크기</th>
            <th class="text-right primary--text">층</th>
          </tr>
        </thead>

        <tbody>
          <tr v-for="(item, index) in apt" :key="index">
            <td>{{ item.dong }}</td>
            <td>{{ item.name }}</td>
            <td>{{ item.amount }}</td>
            <td>{{ item.area }}</td>
            <td class="text-right">{{ item.floor }}</td>
          </tr>
        </tbody>
      </v-simple-table>
    </base-material-card>
  </v-container>
</template>
<script>
import axios from "axios";
var sidores = [];

export default {
  data() {
    return {
      sido: [],
      gugun: [],
      dong: [],
      apt: [],
      sisel: "",
      gugunsel: "",
      dongsel: "",
    };
  },
  created: function () {
    const API_URL = "http://localhost:8080/VueApi/api/apt/sido";
    axios
      .get(API_URL)
      .then((response) => {
        console.log(response);
        const sisi = [];
        sidores = response.data;
        response.data.forEach((element) => {
          sisi.push(element.sidoName);
        });
        console.log(sisi);
        this.sido = sisi;
      })
      .catch((error) => {
        console.log(error);
      });
  },

  watch: {
    sisel: function (val) {
      var param1 = "";
      sidores.forEach((a) => {
        if (a.sidoName == val) {
          param1 = a.sidoCode;
        }
      });
      const API_URL = "http://localhost:8080/VueApi/api/apt/gugun/" + param1;

      axios
        .get(API_URL)
        .then((response) => {
          console.log(response);
          const sisi = [];
          response.data.forEach((element) => {
            sisi.push(element.sidoName);
          });
          this.gugun = sisi;
        })
        .catch((error) => {
          console.log(error);
        });
    },
    gugunsel: function (val) {
      const API_URL = "http://localhost:8080/VueApi/api/apt/dong/" + val;

      axios
        .get(API_URL)
        .then((response) => {
          console.log(response);
          const sisi = [];
          response.data.forEach((element) => {
            sisi.push(element.dong);
          });
          this.dong = sisi;
        })
        .catch((error) => {
          console.log(error);
        });
    },
    dongsel: function (val) {
      const API_URL = "http://localhost:8080/VueApi/api/apt/ddong/" + val;

      axios
        .get(API_URL)
        .then((response) => {
          console.log(response);
          this.apt = response.data;
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },
};
</script>
