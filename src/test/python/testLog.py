import requests

BASE_URL = 'http://localhost:8080'

def test_get_all_logs():
    response = requests.get(f'{BASE_URL}/logs')
    assert response.status_code == 200
    assert response.headers['Content-Type'] == 'application/json'
    assert isinstance(response.json(), list)

def test_create_log():
    payload = {
        "timestamp": "2023-07-05T21:18:21.043255",
        "route": "example"
    }
    response = requests.post(f'{BASE_URL}/logs', json=payload)
    assert response.status_code == 200
    assert response.headers['Content-Type'] == 'application/json'
    response_data = response.json()
    assert response_data["timestamp"] == payload["timestamp"]
    assert response_data["route"] == payload["route"]
