<template>
  <div>
    <q-card class="no-border-radius shadow-0">
      <!--      <q-img src="imgs/waiting.png" style="margin-top: -50px">-->
      <!--      </q-img>-->
      <div>
        <q-spinner-box
          color="primary"
          size="5em"
        />
        <q-spinner-box
          color="positive"
          size="5em"
        />
      </div>
      <div>
        <q-spinner-box
          color="negative"
          size="5em"
        />
        <q-spinner-box
          color="warning"
          size="5em"
        />
      </div>
      <div class="bg-primary row items-center q-mt-xl" style="height: 50px">
        <div class="col">
          <div style="width: 150px" class="text-white oauth-login text-body1">
            授权登陆中。。。
          </div>
        </div>
      </div>
    </q-card>
  </div>
</template>
<script>

import { doOauthLogin } from '@/api/user'
import commonUtil from '@/utils/commonUtil'
import anime from 'animejs'

export default {
  name: 'OauthLogin',
  mounted() {
    this.textAnimal()
    this.doOauthLogin()
  },
  methods: {
    textAnimal() {
      anime({
        targets: '.oauth-login',
        width: '150%', // -> from '28px' to '100%',
        easing: 'easeInOutQuad',
        direction: 'alternate',
        duration: 1300,
        loop: true
      })
    },
    doOauthLogin() {
      doOauthLogin().then(response => {
        console.log('-------------' + response)
        if (response.success) {
          this.success()
        } else {
          this.error(response.message)
        }
      })
    },
    error(message) {
      commonUtil.notifyWaring(message)
      this.$router.push({
        path: '/user/oauth-bind'
      })
    },
    success() {
      commonUtil.notifySuccess('登录成功')
      this.$router.push({
        path: '/'
      })
    }
  }
}
</script>

<style scoped>

</style>
