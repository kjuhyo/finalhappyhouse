<template>
  <div>
    <v-container v-if="getAccessToken" id="user-profile" fluid tag="section">
      <v-row justify="center">
        <v-col cols="12" md="8">
          <base-material-card>
            <template v-slot:heading>
              <div class="display-2 font-weight-light">정보 수정</div>

              <div class="subtitle-1 font-weight-light">Edit Profile</div>
            </template>

            <v-form>
              <v-container class="py-0">
                <v-row>
                  <v-col cols="12" md="6">
                    <v-text-field
                      label="User Id"
                      v-model="user.memId"
                      class="purple-input"
                    />
                  </v-col>

                  <v-col cols="12" md="6">
                    <v-text-field label="User Name" class="purple-input" />
                  </v-col>
                  <v-col cols="12" md="6">
                    <v-text-field
                      type="password"
                      label="Password"
                      class="purple-input"
                    />
                  </v-col>

                  <v-col cols="12" md="6">
                    <v-text-field
                      type="password"
                      label="Password Confirm"
                      class="purple-input"
                    />
                  </v-col>

                  <v-col cols="12">
                    <v-text-field label="E-mail" class="purple-input" />
                  </v-col>

                  <v-col cols="12" class="text-right">
                    <v-btn color="success" class="mr-0"> 수정 </v-btn>
                    <v-btn color="success" class="mr-0"> 탈퇴 </v-btn>
                  </v-col>
                </v-row>
              </v-container>
            </v-form>
          </base-material-card>
        </v-col>

        <v-col cols="12" md="4">
          <base-material-card
            class="v-card-profile"
            avatar="https://demos.creative-tim.com/vue-material-dashboard/img/marc.aba54d65.jpg"
          >
            <v-card-text class="text-center">
              <h6 class="display-1 mb-1 grey--text">
                {{ getmemId }}
              </h6>
              <h4 class="display-2 font-weight-light mb-3 black--text">
                {{ getmemName }}
              </h4>
              <h4 class="display-2 font-weight-light mb-3 black--text">
                <v-btn color="success" class="mr-0" @click="onClickLogout">
                  로그아웃
                </v-btn>
              </h4>
            </v-card-text>
          </base-material-card>
        </v-col>
      </v-row>
    </v-container>

    <v-container v-else id="user-profile" fluid tag="section">
      <v-row justify="center">
        <v-col cols="12" md="8">
          <base-material-card>
            <template v-slot:heading>
              <div class="display-2 font-weight-light">로그인</div>

              <div class="subtitle-1 font-weight-light">Login</div>
            </template>

            <v-form>
              <v-container class="py-0">
                <v-row>
                  <v-col cols="12">
                    <v-text-field
                      id="memId"
                      v-model="user.memId"
                      required
                      label="ID"
                      class="purple-input"
                    />
                  </v-col>
                  <v-col cols="12">
                    <v-text-field
                      type="password"
                      id="memPwd"
                      v-model="user.memPwd"
                      required
                      label="Password"
                      class="purple-input"
                      @keypress.enter="login"
                    />
                  </v-col>

                  <v-col cols="12" class="text-right">
                    <v-btn color="success" class="mr-0" @click="login">
                      로그인
                    </v-btn>
                    <v-btn color="success" class="mr-0" @click="addUser">
                      회원가입
                    </v-btn>
                  </v-col>
                </v-row>
              </v-container>
            </v-form>
          </base-material-card>
        </v-col>

        <v-col cols="12" md="4">
          <base-material-card
            class="v-card-profile"
            avatar="https://dcassetcdn.com/design_img/3198855/647309/647309_17712397_3198855_fb929484_image.jpg"
          >
            <v-card-text class="text-center">
              <h6 class="display-1 mb-1 grey--text">happy house</h6>
            </v-card-text>
          </base-material-card>
        </v-col>
      </v-row>
    </v-container>
  </div>
</template>

<script>
import Vue from "vue";
import VueRouter from "vue-router";
import { mapGetters } from "vuex";

Vue.use(VueRouter);

export default {
  name: "Login",
  data: function() {
    return {
      user: {
        memId: "",
        memPwd: ""
      },
      message: "잘못됨"
    };
  },
  computed: {
    ...mapGetters(["getAccessToken", "getmemId", "getmemName"]),
    nextRoute() {
      return this.$route.params.nextRoute
        ? this.$route.params.nextRoute
        : "pages/user";
    }
  },
  methods: {
    login: function() {
      this.$store
        .dispatch("LOGIN", this.user)
        .then(() => this.$router.replace(`/${this.nextRoute}`))
        .catch(({ message }) => (this.msg = message));
    },
    addUser: function() {
      this.$router.push("/newuser");
    },
    onClickLogout() {
      this.$store
        .dispatch("LOGOUT")
        .then(() => this.$router.replace("/pages/user").catch(() => {}));
    }
  }
};
</script>
