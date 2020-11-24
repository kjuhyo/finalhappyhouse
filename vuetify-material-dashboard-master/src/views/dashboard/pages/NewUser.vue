<template>
  <v-container
    id="user-profile"
    fluid
    tag="section"
  >
    <v-row justify="center">
      <v-col
        cols="12"
        md="8"
      >
        <base-material-card>
          <template v-slot:heading>
            <div class="display-2 font-weight-light">
              회원 가입
            </div>

            <div class="subtitle-1 font-weight-light">
              Join
            </div>
          </template>

          <v-form>
            <v-container class="py-0">
              <v-row>
                <v-col
                  cols="12"
                  md="6"
                >
                  <v-text-field
                    label="User Id"
                    class="purple-input"
                  />
                </v-col>

                <v-col
                  cols="12"
                  md="6"
                >
                  <v-text-field
                    label="User Name"
                    class="purple-input"
                  />
                </v-col>
                <v-col
                  cols="12"
                  md="6"
                >
                  <v-text-field
                    label="Password"
                    class="purple-input"
                  />
                </v-col>

                <v-col
                  cols="12"
                  md="6"
                >
                  <v-text-field
                    label="Password Confirm"
                    class="purple-input"
                  />
                </v-col>

                <v-col cols="12">
                  <v-text-field
                    label="E-mail"
                    class="purple-input"
                  />
                </v-col>

                <v-col
                  cols="12"
                  class="text-right"
                >
                  
                  <v-btn
                    color="success"
                    class="mr-0"
                  >
                    가입
                  </v-btn>
                </v-col>
              </v-row>
            </v-container>
          </v-form>
        </base-material-card>
      </v-col>

      <v-col
        cols="12"
        md="4"
      >
        <base-material-card
          class="v-card-profile"
          avatar="https://demos.creative-tim.com/vue-material-dashboard/img/marc.aba54d65.jpg"
        >
          <v-card-text class="text-center">
            <h6 class="display-1 mb-1 grey--text">
              
            </h6>
            <h4 class="display-2 font-weight-light mb-3 black--text">
              WELCOME TO HAPPY HOUSE
            </h4>
          </v-card-text>
        </base-material-card>
      </v-col>
    </v-row>
  </v-container>

</template>

<script>
  import Vue from 'vue'
  import VueRouter from 'vue-router'

  Vue.use(VueRouter)

  export default {
    name: 'Login',
    data: function () {
      return {
        user: {
          memId: '',
          memPwd: '',
        },
        message: '잘못됨',
      }
    },
    computed: {
      nextRoute () {
      return this.$route.params.nextRoute ? this.$route.params.nextRoute : ''
    },
    },
    methods: {
      login: function () {
         this.$store
         .dispatch('LOGIN', this.user)
         .then(() => this.$router.replace(`/${this.nextRoute}`))
         .catch(({ message }) => (this.msg = message));
      },
      addUser: function (){
        this.$router.push('/NewUser')
      }
    }
  
  }
</script>
