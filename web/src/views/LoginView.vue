<template>
  <a-row class="login">
    <a-col :span="8" :offset="8" class="login-main">
      <h1 style="text-align: center">Ticket System</h1>
      <a-form
        :model="formState"
        name="basic"
        autocomplete="off"
        @finish="onFinish"
        @finishFailed="onFinishFailed"
      >
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
          <a-button type="primary" block html-type="submit">Submit</a-button>
        </a-form-item>
      </a-form>
    </a-col>
  </a-row>
</template>

<script>
import { defineComponent, reactive } from "vue";
import axios from "axios";

export default defineComponent({
  setup() {
    const formState = reactive({
      mobile: "",
      code: "",
    });
    const onFinish = (values) => {
      console.log("Success:", values);
    };
    const onFinishFailed = (errorInfo) => {
      console.log("Failed:", errorInfo);
    };

    const onSendCode = async () => {
      try {
        const response = await axios.post(
          "http://localhost:8000/member/member/loginCode",
          {
            mobile: formState.mobile,
          }
        );

        const receivedCode = response.data.content;
        formState.code = receivedCode;
        console.log("Login code sent successfully:", receivedCode);
      } catch (error) {
        console.error("Error sending login code:", error);
      }
    };
    return {
      formState,
      onFinish,
      onFinishFailed,
      onSendCode,
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
