<template>
  <v-container id="dashboard" fluid tag="section">
    <v-row>
      <v-col cols="12" lg="4">
        <base-material-chart-card
          :data="emailsSubscriptionChart.data"
          :options="emailsSubscriptionChart.options"
          :responsive-options="emailsSubscriptionChart.responsiveOptions"
          color="#E91E63"
          hover-reveal
          type="Bar"
        >
          <template v-slot:reveal-actions>
            <v-tooltip bottom>
              <template v-slot:activator="{ attrs, on }">
                <v-btn v-bind="attrs" color="info" icon v-on="on">
                  <v-icon color="info"> mdi-refresh </v-icon>
                </v-btn>
              </template>

              <span>Refresh</span>
            </v-tooltip>

            <v-tooltip bottom>
              <template v-slot:activator="{ attrs, on }">
                <v-btn v-bind="attrs" light icon v-on="on">
                  <v-icon>mdi-pencil</v-icon>
                </v-btn>
              </template>

              <span>Change Date</span>
            </v-tooltip>
          </template>

          <h4 class="card-title font-weight-light mt-2 ml-2">
            서울 주요 구 거래평균 금액
          </h4>
          <template v-slot:actions>
            <v-icon class="mr-1" small> mdi-clock-outline </v-icon>
            <span class="caption grey--text font-weight-light"
              >updated 1 days ago</span
            >
          </template>
        </base-material-chart-card>
      </v-col>

      <v-col cols="12" lg="4">
        <base-material-chart-card
          :data="dailySalesChart.data"
          :options="dailySalesChart.options"
          color="success"
          hover-reveal
          type="Line"
        >
          <template v-slot:reveal-actions>
            <v-tooltip bottom>
              <template v-slot:activator="{ attrs, on }">
                <v-btn v-bind="attrs" color="info" icon v-on="on">
                  <v-icon color="info"> mdi-refresh </v-icon>
                </v-btn>
              </template>

              <span>Refresh</span>
            </v-tooltip>

            <v-tooltip bottom>
              <template v-slot:activator="{ attrs, on }">
                <v-btn v-bind="attrs" light icon v-on="on">
                  <v-icon>mdi-pencil</v-icon>
                </v-btn>
              </template>

              <span>Change Date</span>
            </v-tooltip>
          </template>

          <h4 class="card-title font-weight-light mt-2 ml-2">
            서울 주요 구 거래량
          </h4>

          <template v-slot:actions>
            <v-icon class="mr-1" small> mdi-clock-outline </v-icon>
            <span class="caption grey--text font-weight-light"
              >updated 1 days ago</span
            >
          </template>
        </base-material-chart-card>
      </v-col>

      <v-col cols="12" lg="4" align="center">
        <v-date-picker v-model="picker" type="month"></v-date-picker>
      </v-col>

      <v-col cols="12" sm="6" lg="4">
        <base-material-stats-card
          color="primary"
          icon="mdi-poll"
          title="주요구군 거래 횟수"
          :value="aptcount"
          sub-icon="mdi-tag"
          sub-text="Tracked from Google Analytics"
        />
      </v-col>

      <v-col cols="12" sm="6" lg="4">
        <base-material-stats-card
          color="success"
          icon="mdi-store"
          title="주요구군 총 거래금액(원)"
          :value="fullamount"
          sub-icon="mdi-calendar"
          sub-text="Last 30 Days"
        />
      </v-col>

      <v-col cols="12" sm="6" lg="4">
        <base-material-stats-card
          color="orange"
          icon="mdi-sofa"
          title="좋아요"
          value="2000000"
          sub-icon="mdi-alert"
          sub-icon-color="red"
          sub-text="Get More Space..."
        />
      </v-col>

      <v-col cols="12" md="12">
        <base-material-card color="warning" class="px-5 py-3">
          <template v-slot:heading>
            <div class="display-2 font-weight-light">
              {{ yearsel }}년 {{ monthsel }}월 서울 주요 구군 거래
            </div>
          </template>
          <v-card-text>
            <v-data-table :headers="headers" :items="Allapts" />
          </v-card-text>
        </base-material-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import axios from "axios";
var years = [];
var months = [
  "01",
  "02",
  "03",
  "04",
  "05",
  "06",
  "07",
  "08",
  "09",
  "10",
  "11",
  "12",
];
for (var i = 2000; i < 2021; i++) {
  years.push(i);
}

export default {
  created: function () {
    this.getAlldata();
  },
  name: "DashboardDashboard",

  data() {
    return {
      picker: new Date().toISOString().substr(0, 10),
      year: years,
      month: months,
      yearsel: 2020,
      monthsel: "11",
      dailySalesChart: {
        data: {
          labels: [
            "강남구",
            "서초구",
            "용산구",
            "송파구",
            "성동구",
            "광진구",
            "마포구",
            "동작구",
          ],
          series: [[1, 2, 3, 4, 5, 6, 7, 8]],
        },
        options: {
          lineSmooth: this.$chartist.Interpolation.cardinal({
            tension: 0,
          }),
          low: 0,
          high: this.maxcount, // creative tim: we recommend you to set the high sa the biggest value + something for a better look
          chartPadding: {
            top: 0,
            right: 0,
            bottom: 0,
            left: 0,
          },
        },
      },
      emailsSubscriptionChart: {
        data: {
          labels: [
            "강남구",
            "서초구",
            "용산구",
            "송파구",
            "성동구",
            "광진구",
            "마포구",
            "동작구",
          ],
          series: [[300, 443, 320, 780, 553, 453, 326, 434]],
        },
        options: {
          axisX: {
            showGrid: false,
          },
          low: 0,
          high: this.maxamount,
          chartPadding: {
            top: 0,
            right: 5,
            bottom: 0,
            left: 0,
          },
        },
        responsiveOptions: [
          [
            "screen and (max-width: 640px)",
            {
              seriesBarDistance: 5,
              axisX: {
                labelInterpolationFnc: function (value) {
                  return value[0];
                },
              },
            },
          ],
        ],
      },
      headers: [
        {
          sortable: true,
          text: "거래 년",
          value: "년",
        },
        {
          sortable: true,
          text: "월",
          value: "월",
        },
        {
          sortable: true,
          text: "일",
          value: "일",
        },
        {
          sortable: true,
          text: "법정동",
          value: "법정동",
        },
        {
          sortable: true,
          text: "아파트",
          value: "아파트",
        },
        {
          sortable: true,
          text: "거래금액",
          value: "거래금액",
        },
        {
          sortable: true,
          text: "전용면적",
          value: "전용면적",
        },
      ],
      tabs: 0,
      places: [11680, 11650, 11170, 11710, 11200, 11215, 11440, 11590],
      Allapts: [],
      countApt: [],
      amountApt: [],
      aptcount: "0",
      aptcountnum: 0,
      fullamount: "0",
      fullamountnum: 0,
    };
  },
  watch: {
    picker: function (val) {
      this.yearsel = val.substr(0, 4);
      this.monthsel = val.substr(5, 6);
      this.getAlldata();
    },
  },
  methods: {
    complete(index) {
      this.list[index] = !this.list[index];
    },

    getAlldata() {
      this.Allapts = [];
      this.countApt = [];
      this.amountApt = [];

      this.aptcountnum = 0;

      this.fullamountnum = 0;
      this.places.forEach((element) => {
        this.getdata(element, this.yearsel + "" + this.monthsel);
      });
      this.maxcount = Math.max.apply(null, this.countApt) + 100;
      this.maxamount = Math.max.apply(null, this.amountApt) + 1000;
      this.dailySalesChart.data.series = [this.countApt];
      this.emailsSubscriptionChart.data.series = [this.amountApt];
    },
    getdata(placecode, day) {
      const API_KEY =
        "UzlzGSkGFVAEyXGrO0GzbQ17HBeJ2CntOm1FQzcdlSBh%2Fm%2BXGI5VL8f9gc6oCcN%2B2pMcP4pF4Mq%2FCO6fpIo4ww%3D%3D";
      const API_KEY2 =
        "aCxmYY6fT6MMq7m8OMA7NIF5YzME2immau68Y%2Bcmqfv6JSfBLszsF%2BDEhqjN0Ux5F6kkgDUQXyGelcWP%2F4LbeA%3D%3D";
      const API_URL =
        "http://openapi.molit.go.kr/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTradeDev?serviceKey=" +
        API_KEY +
        "&pageNo=1&numOfRows=1000&LAWD_CD=" +
        placecode +
        "&DEAL_YMD=" +
        day;

      axios
        .get(API_URL)
        .then((response) => {
          var amountt = 0;
          response.data.response.body.items.item.forEach((a) => {
            amountt = amountt + parseInt(a.거래금액.replace(",", "")) / 100;
            this.fullamountnum =
              this.fullamountnum + parseInt(a.거래금액.replace(",", "")) * 1000;
            this.fullamount = "" + this.fullamountnum;
            this.Allapts.push(a);
          });
          var num = parseInt(response.data.response.body.totalCount);
          this.amountApt.push(amountt / num);
          this.aptcountnum = this.aptcountnum + num;
          this.aptcount = "" + this.aptcountnum;
          this.countApt.push(num);
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },
};
</script>
