<template>
  <a-row class="login">
    <a-col :span="8" :offset="8" class="login-main">
      <h1 style="text-align: center">Ticket System</h1>
      <a-form :model="formState" name="basic" autocomplete="off">
        <a-form-item
          label=""
          name="mobile"
          :rules="[{ required: true, message: 'Please input your mobile!' }]"
        >
          <a-input v-model:value="formState.mobile" placeholder="mobile" />
        </a-form-item>
        <a-form-item
          label=""
          name="code"
          :rules="[
            { required: true, message: 'Please input verification code!' },
          ]"
        >
          <a-input v-model:value="formState.code" placeholder="code">
            <template #addonAfter>
              <a type="primary" @click="onSendCode">get code</a>
            </template>
          </a-input>
        </a-form-item>

        <a-form-item>
          <a-button type="primary" block @click="onLogin">Submit</a-button>
        </a-form-item>
      </a-form>
    </a-col>
  </a-row>
</template>

<script>
import { defineComponent, reactive } from "vue";
import { message } from "ant-design-vue";
import { useRouter } from "vue-router";

import axios from "axios";

export default defineComponent({
  setup() {
    const router = useRouter();
    const formState = reactive({
      mobile: "",
      code: "",
    });
    const onSendCode = async () => {
      try {
        const response = await axios.post("/member/member/loginCode", {
          mobile: formState.mobile,
        });

        const data = response.data;
        if (data.success) {
          formState.code = data.content;
        } else {
          message.error(data.message);
        }
        console.log("Login code sent successfully");
      } catch (error) {
        console.error("Error sending login code:", error);
      }
    };
    const onLogin = async () => {
      try {
        const response = await axios.post("/member/member/login", {
          ...formState,
        });
        const data = response.data;
        if (data.success) {
          formState.code = data.code;
        } else {
          message.error(data.message);
        }
        message.info("Login successful!");
        await router.push("/");
      } catch (error) {
        console.error("Error during login:", error);
      }
    };
    return {
      formState,
      onSendCode,
      onLogin,
    };
  },
});
</script>

<style>
.login-main h1 {
  font-size: 25px;
  font-weight: bold;
}
.login-main {
  margin-top: 100px;
  padding: 30px 30px 20px;
  border: 2px solid grey;
  border-radius: 10px;
  background-color: #fcfcfc;
}
</style>
