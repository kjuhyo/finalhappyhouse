<template>
  <v-container id="google-maps" fluid tag="section">
    <v-text-field
      :label="$t('search')"
      v-model="place"
      color="secondary"
      hide-details
      style="max-width: 165px"
    >
      <template v-if="$vuetify.breakpoint.mdAndUp" v-slot:append-outer>
        <v-btn class="mt-n2" @click="changeplace" elevation="1" fab small>
          <v-icon>mdi-magnify</v-icon>
        </v-btn>
      </template>
    </v-text-field>
    <v-row>
      <v-col cols="12">
        <base-material-card
          color="success"
          title="Satellite Map"
          class="px-5 py-3"
        >
          <v-card-text class="px-0 pb-0">
            <v-sheet>
              <iframe
                :src="sauce"
                width="100%"
                height="450"
                frameborder="0"
                style="border: 0"
                allowfullscreen
              />
            </v-sheet>
          </v-card-text>
        </base-material-card>
      </v-col>
    </v-row>
  </v-container>
</template>
<script>
export default {
  data() {
    return {
      place: "",

      basic:
        "https://www.google.com/maps/embed/v1/place?key=AIzaSyDfNM5htZIYTmiGUSoJyBoTTpD07Un_PcY&q=",
      sauce:
        "https://www.google.com/maps/embed/v1/place?key=AIzaSyDfNM5htZIYTmiGUSoJyBoTTpD07Un_PcY&q=대한민국",
    };
  },
  methods: {
    changeplace: function () {
      if (this.place == "") {
        this.place = "대한민국";
      }

      this.sauce = this.basic + this.place;
    },
  },
};
</script>
